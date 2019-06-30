package com.love.movie.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.love.movie.mapper.AttitudeMapper;
import com.love.movie.mapper.CommentMapper;
import com.love.movie.mapper.CustomedCommentMapper;
import com.love.movie.mapper.ReplyMapper;
import com.love.movie.mapper.ReportMapper;
import com.love.movie.mapper.StoreupMapper;
import com.love.movie.model.Attitude;
import com.love.movie.model.AttitudeExample;
import com.love.movie.model.Comment;
import com.love.movie.model.Reply;
import com.love.movie.model.Report;
import com.love.movie.model.ReportExample;
import com.love.movie.model.Storeup;
import com.love.movie.model.StoreupExample;
import com.love.movie.model.StoreupExample.Criteria;
import com.love.movie.service.CommentService;

@Service("commentService")
public class CommentServiceImpl implements CommentService {

	@Autowired
	private CustomedCommentMapper customedCommentMapper;

	@Autowired
	private CommentMapper commentMapper;
	
	@Autowired
	private StoreupMapper storeMapper;
	
	@Autowired
	private AttitudeMapper attitudeMapper;
	
	@Autowired
	private ReportMapper reportMapper;
	
	@Autowired
	private ReplyMapper replyMapper;
	

	@Override
	public List<Map<String, Object>> getLikeComment() {
		List<Map<String, Object>> commentsList = customedCommentMapper.getLikeComment();
		return commentsList;
	}

	@Override
	public List<Map<String, Object>> getPopularComment() {
		List<Map<String, Object>> commentsList = customedCommentMapper.getPopularComment();
		return commentsList;
	}

	@Override
	public List<Map<String, Object>> getHotComment() {
		List<Map<String, Object>> commentsList = customedCommentMapper.getHotComment();
		return commentsList;
	}

	@Override
	public List<Map<String, Object>> getNewComment() {
		List<Map<String, Object>> commentsList = customedCommentMapper.getNewComment();
		return commentsList;
	}

	@Override
	public List<Map<String, Object>> getCommentByMid(int mid) {
		List<Map<String, Object>> commentsList = customedCommentMapper.selectCommentByMid(mid);
		return commentsList;
	}

	@Override
	public Map<String, Object> getCommentByCid(int cid) {
		Map<String, Object> comment = customedCommentMapper.selectCommentByCid(cid);
		return comment;
	}

	@Override
	public List<Map<String, Object>> getAllComment() {
		List<Map<String, Object>> commentsList = customedCommentMapper.getAllComment();
		return commentsList;
	}

	@Override
	public List<Map<String, Object>> getMAllComment() {
		List<Map<String, Object>> commentsList = customedCommentMapper.getMAllComment();
		return commentsList;
	}

	@Override
	public List<Map<String, Object>> getAllHotComment() {
		List<Map<String, Object>> commentsList = customedCommentMapper.getAllHotComment();
		return commentsList;
	}

	@Override
	public List<Map<String, Object>> getAllNewComment() {
		List<Map<String, Object>> commentsList = customedCommentMapper.getAllNewComment();
		return commentsList;
	}

	@Override
	public List<Map<String, Object>> getPopularCommentByMid(int mid) {
		return customedCommentMapper.getPopularCommentByMid(mid);
	}

	@Override
	public List<Map<String, Object>> getHotCommentByMid(int mid) {
		return customedCommentMapper.getHotCommentByMid(mid);
	}

	@Override
	public List<Map<String, Object>> getNewCommentByMid(int mid) {
		return customedCommentMapper.getNewCommentByMid(mid);
	}

	@Override
	public List<Map<String, Object>> getFriendCommentByMid(Comment comment) {
		return customedCommentMapper.getFriendCommentByMid(comment);
	}

	@Override
	public int getCommentReplyCountByCid(int cid) {
		return customedCommentMapper.getCommentReplyCountByCid(cid);
	}

	@Override
	public Integer getCommentStroeCount(int cid) {
		return customedCommentMapper.getCommentStroeCount(cid);
	}

	@Override
	public Integer getUserAttitudeToComment(Attitude attitude) {
		return customedCommentMapper.getUserAttitudeToComment(attitude);
	}

	@Override
	public Boolean isStoreComment(int cid, int uid) {
		StoreupExample sExmple = new StoreupExample();
		
		Criteria criteria = sExmple.createCriteria();
		criteria.andCidEqualTo(cid);
		criteria.andUidEqualTo(uid);		
		List<Storeup> storeups = storeMapper.selectByExample(sExmple);
		if(storeups.isEmpty() == false) {
			return true;
		}
		return false;
	}

	@Override
	public Boolean cancelStoreComment(int cid, int uid) {
		
		StoreupExample storeupExample = new StoreupExample();
		
		com.love.movie.model.StoreupExample.Criteria criteria = storeupExample.createCriteria();
		criteria.andCidEqualTo(cid);
		criteria.andUidEqualTo(uid);
		//取消收藏 删除记录
		int n = storeMapper.deleteByExample(storeupExample);
		if(n>=1) {
			return true;
		}
		return false;
	}

	@Override
	public Boolean storeComment(int cid, int uid) {
		
		Storeup storeup = new Storeup();
		storeup.setCid(cid);
		storeup.setUid(uid);
		storeup.setStoredate(new Date());
		//收藏 增加记录
		int n = storeMapper.insertSelective(storeup);
		if(n>=1) {
			return true;
		}
		return false;
	}

	@Override
	public Boolean doThumbUpComment(int cid, int uid) {
		//点赞评论 如果原来踩了取消踩
		//获取对此评论的状态
		Attitude attitude = new Attitude();
		attitude.setCid(cid);
		attitude.setUid(uid);
		
		Integer thumbAttitude = customedCommentMapper.getUserAttitudeToComment(attitude);
		
		//如果没有评论过
		if(thumbAttitude == null) {
			attitude.setAttitude(1);	//赞成
			attitudeMapper.insert(attitude);	//插入
			
			//更新comment表
			Comment comment = commentMapper.selectByPrimaryKey(cid);
			int like = comment.getClike() + 1;
			comment.setClike(like);
			int n = commentMapper.updateByPrimaryKey(comment);
			System.out.println("没有评论过 赞了的结果 " + n);
			
		}else {
			//评论过
			AttitudeExample attitudeExample = new AttitudeExample();
			com.love.movie.model.AttitudeExample.Criteria criteria = attitudeExample.createCriteria();
			criteria.andUidEqualTo(uid);
			criteria.andCidEqualTo(cid);
			Attitude oldAttitude = attitudeMapper.selectByExample(attitudeExample).get(0);
			int isUp = oldAttitude.getAttitude();
			oldAttitude.setAttitude(1);
			attitudeMapper.updateByPrimaryKey(oldAttitude);	//更新状态
			
			//原来状态为踩
			if(isUp == 0) {
				//更新comment表
				Comment comment = commentMapper.selectByPrimaryKey(cid);
				int like = comment.getClike() + 1;
				comment.setClike(like);
				comment.setCdislike(comment.getCdislike()-1);
				int n = commentMapper.updateByPrimaryKey(comment);
				System.out.println("评论过 赞了 原来是踩了的结果 " + n);
			}else {
				//原状态就为赞 则不用更新comment
				System.out.println("评论过 赞了 原来是赞了的结果 ");
			}
		}
		return true;
	}

	@Override
	public Boolean cancelThumbUpComment(int cid, int uid) {
		AttitudeExample attitudeExample = new AttitudeExample();
		com.love.movie.model.AttitudeExample.Criteria criteria = attitudeExample.createCriteria();
		criteria.andUidEqualTo(uid);
		criteria.andCidEqualTo(cid);
		Attitude oldAttitude = attitudeMapper.selectByExample(attitudeExample).get(0);
		attitudeMapper.deleteByPrimaryKey(oldAttitude.getAid());	//取消点赞删除
		
		//更新comment表中的点赞数
		Comment comment = commentMapper.selectByPrimaryKey(cid);
		comment.setClike(comment.getClike()-1);
		commentMapper.updateByPrimaryKey(comment);
		
		return true;
	}

	@Override
	public Boolean doThumDownComment(int cid, int uid) {
		//踩评论 如果原来赞了取消赞
		
		//获取对此评论的状态
		Attitude attitude = new Attitude();
		attitude.setCid(cid);
		attitude.setUid(uid);
		
		Integer thumbAttitude = customedCommentMapper.getUserAttitudeToComment(attitude);
		
		//如果没有评论过
		if(thumbAttitude == null) {
			attitude.setAttitude(0);	//踩
			attitudeMapper.insert(attitude);	//插入
			
			//更新comment表
			Comment comment = commentMapper.selectByPrimaryKey(cid);
			comment.setCdislike(comment.getCdislike()+1);
			int n = commentMapper.updateByPrimaryKey(comment);
			System.out.println("没有评论过 踩了的结果 " + n);
			
		}else {
			//评论过
			AttitudeExample attitudeExample = new AttitudeExample();
			com.love.movie.model.AttitudeExample.Criteria criteria = attitudeExample.createCriteria();
			criteria.andUidEqualTo(uid);
			criteria.andCidEqualTo(cid);
			Attitude oldAttitude = attitudeMapper.selectByExample(attitudeExample).get(0);
			int isUp = oldAttitude.getAttitude();
			oldAttitude.setAttitude(0);
			attitudeMapper.updateByPrimaryKey(oldAttitude);	//更新状态
			
			//原来状态为赞
			if(isUp == 1) {
				//更新comment表
				Comment comment = commentMapper.selectByPrimaryKey(cid);
				int like = comment.getClike() - 1;
				comment.setClike(like);
				comment.setCdislike(comment.getCdislike()+1);
				int n = commentMapper.updateByPrimaryKey(comment);
				System.out.println("评论过 踩了 原来是赞了的结果 " + n);
			}else {
				//原状态就为赞 则不用更新comment
				System.out.println("评论过 踩了 原来是踩了的结果 ");
			}
		}
		return true;
	}
	
	
	
	

	@Override
	public Boolean cancelThumDownComment(int cid, int uid) {
		AttitudeExample attitudeExample = new AttitudeExample();
		com.love.movie.model.AttitudeExample.Criteria criteria = attitudeExample.createCriteria();
		criteria.andUidEqualTo(uid);
		criteria.andCidEqualTo(cid);
		Attitude oldAttitude = attitudeMapper.selectByExample(attitudeExample).get(0);
		attitudeMapper.deleteByPrimaryKey(oldAttitude.getAid());	//取消踩 删除
		
		//更新comment表中的点赞数
		Comment comment = commentMapper.selectByPrimaryKey(cid);
		comment.setCdislike(comment.getCdislike()-1);
		commentMapper.updateByPrimaryKey(comment);
		return null;
	}

	@Override
	public Boolean doReport(String reason, int cid, int uid) {
		
		//修改comment的report字段状态
		Comment comment = commentMapper.selectByPrimaryKey(cid);
		comment.setReport(1);
		commentMapper.updateByPrimaryKey(comment);
		
		//查询举报表中是否存在该评论的举报信息，若是存在则更新该评论的举报信息，不存在则插入
		ReportExample reportExample = new ReportExample();
		com.love.movie.model.ReportExample.Criteria criteria = reportExample.createCriteria();
		criteria.andCidEqualTo(cid);
		List<Report> reports=  reportMapper.selectByExample(reportExample);
		if(reports.isEmpty()) {
			//插入举报信息
			Report report = new Report();
			report.setCid(cid);
			report.setUid(uid);
			report.setReason(reason);
			report.setReportdate(new Date());
			reportMapper.insertSelective(report);
			
		}else {
			Report report = reports.get(0);
			report.setUid(uid);
			report.setReportdate(new Date());
			report.setReason(reason);
			reportMapper.updateByPrimaryKey(report);
		}
		return true;
	}

	@Override
	public boolean doAddReplyToComment(String content, int cid, int uid, int touid) {
		
		Reply reply = new Reply();
		reply.setCid(cid);
		reply.setReplyid(cid);
		reply.setRcontent(content);
		reply.setRdate(new Date());
		reply.setReplytype(0);  //直接回复影评
		reply.setReport(0);  //默认没有被举报
		reply.setTouid(touid);
		reply.setUid(uid);
		
		int n = replyMapper.insert(reply);
		if(n>=0) {			
			return true;
		}
		return false;
	}

	@Override
	public List<Map<String, Object>> getReplyToCommentByCid(int cid) {
		return customedCommentMapper.getReplyToCommentByCid(cid);
	}
}

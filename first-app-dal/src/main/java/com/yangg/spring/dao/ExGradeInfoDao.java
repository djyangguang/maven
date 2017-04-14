package com.yangg.spring.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.yangg.spring.model.QueryBean;
import com.yangg.spring.model.TbGradeInfo;
import com.yangg.spring.model.TbGradeInfoExample;
import com.yangg.spring.page.Page;

public interface ExGradeInfoDao {
	//分页 一个查询 还要声明个bean 不合适  这样使用 ibats 自带的 example  不能用 了
	//List<TbGradeInfo> list=gradeInfoDao.selectByExample(example); 不能使用这样的联合查询
	//public List<TbGradeInfo> findByPage(QueryBean queryBeeqn);
	public List<TbGradeInfo> findbyPage(TbGradeInfoExample example,Page page);

}

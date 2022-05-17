package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.demo.entity.Memo;

@Mapper
public interface MemoMapper {
	// 全件取得
	public List<Memo> findAll();

	// 1件取得
	public Optional<Memo> findById(int id);

	// 登録
	public void insertOne(Memo memo);

	// 更新
	public void updateOne(@Param("id") int id, @Param("title") String title, @Param("category") String category,
			@Param("description") String description, @Param("date") String date, @Param("mark_div") int mark_div);

	// 削除
	public Integer deleteOne(int id);

}

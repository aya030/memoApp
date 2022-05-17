package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import com.example.demo.entity.Memo;
import com.example.demo.repository.MemoMapper;

@Service
@Transactional
public class MemoService {
	private final MemoMapper memoMapper;

	public MemoService(MemoMapper memoMapper) {
		this.memoMapper = memoMapper;
	}

	// 全件取得
	public List<Memo> getMemoList() {
		return memoMapper.findAll();
	}

	// 1件取得
	public Optional<Memo> findById(int id) {
		return memoMapper.findById(id);
	}

	// 新規登録
	public void insertOne(@Validated Memo memo) {
		memoMapper.insertOne(memo);
	}

	// 更新
	public void updateOne(int id, String title, String category, String description, String date, int mark_div) {
		memoMapper.updateOne(id, title, category, description, date, mark_div);
	}

	// 削除
	public void deleteOne(int id) {
		memoMapper.deleteOne(id);
	}

}

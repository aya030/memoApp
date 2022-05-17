package com.example.demo.controller;

import java.util.List;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Memo;
import com.example.demo.service.MemoService;

@RestController
@Validated
@RequestMapping
public class MemoController {
	private final MemoService memoService;

	public MemoController(MemoService memoService) {
		this.memoService = memoService;
	}

	/* Top */
	@GetMapping("/memos")
	public List<Memo> index() {
		return memoService.getMemoList();
	}

	/* 新規登録 */
	@PostMapping("/memo")
	public void create(@RequestBody Memo memo) {

		memoService.insertOne(memo);
	}

	/* 更新 */
	@GetMapping("/memo/id={id}")
	public void edit(@PathVariable("id") int id) {

		memoService.findById(id).get();

	}

	@PutMapping("/memo/id={id}")
	public void update(Model model,@PathVariable("id") int id,@RequestBody @Validated Memo memo, BindingResult result) {

		memoService.updateOne(id, memo.getTitle(), memo.getCategory(), memo.getDescription(), memo.getDate(),
				memo.getMark_div());
	}

	/* 削除 */
	@DeleteMapping("/memo/id={id}")
	public void delete(@PathVariable("id") int id) {

		memoService.deleteOne(id);
	}

}

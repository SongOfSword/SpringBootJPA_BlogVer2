package com.web.blog.dto;

import lombok.Data;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Builder;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
// 응답시 제대로 처리해서 응답됐는지 등을 처리하는 클래스
public class ResponseDto<T> {
	HttpStatus status;
	T data;
}

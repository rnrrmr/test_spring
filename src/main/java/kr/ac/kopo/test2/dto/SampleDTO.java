package kr.ac.kopo.test2.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data   // 데이터 입출입
@Builder(toBuilder = true)
public class SampleDTO {
    // 데이터의 종류에 따른 필드들을 선언
    private Long sno;  // 순차적인 번호 저장
    private String first;
    private String last;
    private LocalDateTime regTime; // 날짜와 시간정보 저장


}

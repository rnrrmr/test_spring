package kr.ac.kopo.test2.controller;

import kr.ac.kopo.test2.dto.SampleDTO;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
@RequestMapping("/sample")
@Log4j2
public class SampleController {

    @GetMapping("/ex1")
    public void ex1(){
        log.info("ex1이 실행됩니다");
    }

    @GetMapping({"/ex2", "/exLink"})
    public void exModel(Model model){
        log.info("ex2가 실행됩니다");
        // 데이터를 저장하기 위해 초기화 / 리스트 객체 생성 - 반복적으로 작업
        List<SampleDTO> list = IntStream.rangeClosed(1,20).asLongStream().mapToObj(
                i -> {
                    SampleDTO dto = SampleDTO.builder()
                            .sno(i)
                            .first("First.. "+i)
                            .last("Last.. "+i)
                            .regTime(LocalDateTime.now())
                            .build();
                    return dto;
                }
            ).collect(Collectors.toList());
        //int스트림에서 값을 반환받아 longStream 형태로 변환
        model.addAttribute("list", list);
    }

    @GetMapping({"/exInline"})
    public String exInline(RedirectAttributes redirectAttributes){
        log.info("exInline이 실행");
        SampleDTO dto = SampleDTO.builder()
                .sno(100L)
                .first("First...100")
                .last("Last...100")
                .regTime(LocalDateTime.now())
                .build();
        redirectAttributes.addFlashAttribute("result", "success");
        redirectAttributes.addFlashAttribute("dto", dto);

        return "redirect:/sample/ex3";
    }

    @GetMapping("/ex3")
    public void ex3(){
        log.info("ex3가 실행됩니다");
    }

    @GetMapping("/exLayout1")
    public void exLayout1(){
        log.info("exLayout이 실행됩니다");
    }
}

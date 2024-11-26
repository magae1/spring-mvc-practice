package org.conan.controller;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.conan.domain.Board;
import org.conan.service.BoardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Log4j
@Controller
@RequestMapping("/board/*")
@AllArgsConstructor
public class BoardController {
    private BoardService boardService;

    @GetMapping("/list")
    public void list(Model model) {
        log.info("Board list");
        model.addAttribute("bList", boardService.getAllBoards());
    }

    @PostMapping("/write")
    public String register(Board board, RedirectAttributes rattr) {
        log.info("Board register");
        boardService.write(board);
        rattr.addFlashAttribute("result", board.getBno());
        return "redirect:/board/list";
    }

    @GetMapping("/read")
    public void read(@RequestParam("bno") Integer bno, Model model) {
        System.out.println("Board read: " + bno);
        model.addAttribute("board", boardService.read(bno));
    }

    @PostMapping("modify")
    public String modify(Board board, RedirectAttributes rattr) {
        log.info("Board modify: " + board);
        if (boardService.modify(board)) {
            rattr.addFlashAttribute("result", "success");
        } else {
            rattr.addFlashAttribute("result", "fail");
        }
        return "redirect:/board/list";
    }

    @PostMapping("/remove")
    public String remove(@RequestParam("bno") Integer bno, RedirectAttributes rattr) {
        log.info("Board remove: " + bno);
        if (boardService.remove(bno)) {
            rattr.addFlashAttribute("result", "success");
        } else {
            rattr.addFlashAttribute("result", "fail");
        }
        return "redirect:/board/list";
    }

}

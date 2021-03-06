package org.zerock.oscatest.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.zerock.oscatest.dto.*;
import org.zerock.oscatest.service.BidderService;
import org.zerock.oscatest.service.ContractService;

import java.security.Principal;

@Log4j2
@Controller
@RequestMapping("/contract/")
@RequiredArgsConstructor
@PreAuthorize("hasRole('ROLE_COMPANY') or hasRole('ROLE_MEMBER')")
public class ContractController {

    private final ContractService contractService;

    @GetMapping("/add/list")
    public void addListGET(ContractAddListDTO contractAddListDTO, Model model, Principal principal){
        log.info("=================================");
        log.info("My Add Contract");
        log.info(contractAddListDTO);
        contractAddListDTO.setRequester(principal.getName());
        log.info(contractAddListDTO);
        ListResponseDTO<ContractDTO> responseDTO = contractService.getAddList(contractAddListDTO);

        model.addAttribute("dtoList",responseDTO.getDtoList());
        int total= responseDTO.getTotal();
        model.addAttribute("pageMaker",new PageMaker(contractAddListDTO.getPage(),total));
    }


    //auction main ===============================================================================
    @GetMapping("/list")
    public void auctionGET(ListDTO listDTO, Model model){
        log.info("=================================");
        log.info("auction");
        log.info(listDTO);
        ListResponseDTO<ContractDTO> responseDTO = contractService.getList(listDTO);
        model.addAttribute("dtoList",responseDTO.getDtoList());
        int total = responseDTO.getTotal();
        model.addAttribute("pageMaker", new PageMaker(listDTO.getPage(),total));
    }


    @PostMapping("/updatenego/{conNo}")
    public void updateAsNegotiation(@PathVariable("conNo") Integer conNo){
        log.info(conNo);
        contractService.updateAsNegotiation(conNo);
    }

    @GetMapping("/del/list")
    public void delListGET(){

    }


    @GetMapping("/progress/list")
    public void progressListGET(){

    }

    @GetMapping("/finish/list")
    public void finshListGET(){

    }
}

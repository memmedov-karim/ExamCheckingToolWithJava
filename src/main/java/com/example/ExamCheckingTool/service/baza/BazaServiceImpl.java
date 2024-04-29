package com.example.ExamCheckingTool.service.baza;

import com.example.ExamCheckingTool.dto.NewBazaDto;
import com.example.ExamCheckingTool.entity.Baza;
import com.example.ExamCheckingTool.entity.User;
import com.example.ExamCheckingTool.repository.BazaRepository;
import com.example.ExamCheckingTool.security.JwtService;
import com.example.ExamCheckingTool.validator.DtoValidator;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BazaServiceImpl implements BazaService{
    private final BazaRepository bazaRepository;
    private final DtoValidator dtoValidator;
    private final JwtService jwtService;
    @Override
    public Baza saveBaza(@Valid @NotNull NewBazaDto newBazaDto, HttpServletRequest request){
        User existingUser = jwtService.getUserIdFromToken(request,"token");
        dtoValidator.validateDto(newBazaDto);
        Baza newBazaInstance = new Baza();
        newBazaInstance.setAffectedargumentids(newBazaDto.getAffectedargumentids());
        newBazaInstance.setHowmanyscorethatwrongaffectedtocorrect(newBazaDto.getHowmanyscorethatwrongaffectedtocorrect());
        newBazaInstance.setUser(existingUser);
        return bazaRepository.save(newBazaInstance);
    }


}

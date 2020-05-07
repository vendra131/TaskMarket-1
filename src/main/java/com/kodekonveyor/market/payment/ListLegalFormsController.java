package com.kodekonveyor.market.payment;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

public class ListLegalFormsController {

  @Autowired
  private LegalFormEntityRepository legalFormEntityRepository;

  @GetMapping("/legalform")
  public List<LegalFormDTO> call() {
    final Iterable<LegalFormEntity> allLegalForms =
        legalFormEntityRepository.findAll();
    return StreamSupport.stream(allLegalForms.spliterator(), false)
        .map(this::convertLegalFormToDTO)
        .collect(Collectors.toList());
  }

  private LegalFormDTO convertLegalFormToDTO(final LegalFormEntity entity) {
    final LegalFormDTO result = new LegalFormDTO();
    result.setId(entity.getId());
    result.setCountry(entity.getCountry());
    result.setLegalFormName(entity.getLegalFormName());

    return result;
  }

}

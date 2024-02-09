package org.minami.minamiblog.cmt;

import lombok.RequiredArgsConstructor;
import org.minami.minamiblog.cmt.model.CmtInsParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/cmt")
public class CmtController {
    private final CmtService service;

    @PostMapping
    public int insCmt(@RequestBody CmtInsParam p) {
        return service.insCmt(p);
    }
}

package vn.tiki.zeus.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;
import vn.tiki.zeus.ZeusResponseWrapper;
import vn.tiki.zeus.audit.record.AuditLogListingCriteria;
import vn.tiki.zeus.managers.audit.AuditLogManager;

import java.util.Map;

@RestController
@RequestMapping("/v1/auditlogs")
@AllArgsConstructor
public class AuditController {

    @NonNull
    private ObjectMapper objectMapper;

    @NonNull
    private AuditLogManager auditLogManager;

    @GetMapping
    //TODO authorize request
    public ZeusResponseWrapper<?> readAll(@ApiIgnore @RequestParam(required = false) Map<String, String> params) {
        var criteria = objectMapper.convertValue(params, AuditLogListingCriteria.class);
        return ZeusResponseWrapper.success(auditLogManager.findAll(criteria));
    }
}

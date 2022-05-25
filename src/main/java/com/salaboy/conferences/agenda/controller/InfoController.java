package com.salaboy.conferences.agenda.controller;

import com.salaboy.conferences.agenda.model.ServiceInfo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class InfoController {

    @Value("${version:0.0.0}")
    private String version;

    @Value("${POD_ID:}")
    private String podId;

    @Value("${POD_NODE_NAME:}")
    private String podNodeName;

    @Value("${POD_NAMESPACE:}")
    private String podNamespace;

    @GetMapping("/info")
    public ServiceInfo getInfo() {
        return new ServiceInfo(
                "Agenda Service",
                "v"+version,
                "https://github.com/salaboy/fmtok8s-agenda-rest/releases/tag/v" + version,
                podId,
                podNamespace,
                podNodeName);
    }
}

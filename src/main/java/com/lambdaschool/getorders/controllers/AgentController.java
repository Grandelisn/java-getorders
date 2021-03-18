package com.lambdaschool.getorders.controllers;

import com.lambdaschool.getorders.models.Agent;
import com.lambdaschool.getorders.services.AgentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//The entry point for clients to access Agent data
@RestController
@RequestMapping("/agents")
public class AgentController {

    //Using the agent service
    @Autowired
    AgentsService agentsService;

    /*
        Returns a single agent based off a restaurant id number
        <br> Example: <a href="http://localhost:2019/agents/agent/12">http://localhost:2019/agents/agent/12</a>

        @param agentid The primary key number of the agent you seek
        @return JSON of the agent you seek with a status of OK
        @see AgentsService#findAgentById(long)      AgentsService.findAgentById(long)
     */
    @GetMapping(value = "/agent/{agentid}")
    public ResponseEntity<?> getAgentById(@PathVariable long agentid){

        Agent a = agentsService.findAgentById(agentid);
        return new ResponseEntity<>(a,
            HttpStatus.OK);
    }

}

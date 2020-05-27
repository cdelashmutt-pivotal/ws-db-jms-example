package com.vmware.tanzu.se.wsdbjmsexample.webservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.util.GregorianCalendar;

import javax.xml.bind.JAXBElement;
import javax.xml.datatype.DatatypeFactory;

import com.example.amend.AmendBatchFareAdj;
import com.example.amend.AmendBatchFareAdjResponse;
import com.example.amend.AmendResponseType;
import com.example.amend.ObjectFactory;

@Endpoint
public class AmenderEndpoint {
    private static final String NAMESPACE_URI = "http://amend.example.com/";
    
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "amendBatchFareAdj")
	@ResponsePayload
	public JAXBElement<AmendBatchFareAdjResponse> amendBatchFareAdj(@RequestPayload JAXBElement<AmendBatchFareAdj> request) {
        AmendBatchFareAdj amendRequest = request.getValue();
 
        AmendResponseType responseType = new AmendResponseType();
        responseType.setResponseId(1);
        responseType.setResponseTime(DatatypeFactory.newDefaultInstance().newXMLGregorianCalendar(new GregorianCalendar()));

        AmendBatchFareAdjResponse response = new AmendBatchFareAdjResponse();
        response.setAmendBatchFareAdjRes(responseType);

        return new ObjectFactory().createAmendBatchFareAdjResponse(response);
	}

}
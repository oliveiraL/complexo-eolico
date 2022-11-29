package br.com.ada.letscode.monitoramentoEolico.service;

import br.com.ada.letscode.monitoramentoEolico.domain.ComplexoEolico;
import br.com.ada.letscode.monitoramentoEolico.exceptions.ComplexoEolicoNotFound;
import br.com.ada.letscode.monitoramentoEolico.repository.ComplexoEolicoRepository;
import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSAsync;
import com.amazonaws.services.sqs.model.MessageAttributeValue;
import com.amazonaws.services.sqs.model.SendMessageRequest;
import lombok.RequiredArgsConstructor;
import org.apache.commons.collections4.IterableUtils;
import org.springframework.cloud.aws.messaging.listener.annotation.SqsListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Service;


import java.util.HashMap;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ComplexoEolicoServiceImpl implements ComplexoEolicoService {


    private final ComplexoEolicoRepository complexoEolicoRepository;
//    private final AmazonSQSAsync sqs;

    @Override
    public List<ComplexoEolico> list(String name) {
        if (name == null) {
            return IterableUtils.toList(complexoEolicoRepository.findAll());
        }
        return IterableUtils.toList(complexoEolicoRepository.findAllByNameContains(name));
    }


    @Override
    public ComplexoEolico save(ComplexoEolico complexoEolico) {

        ComplexoEolico complexoEolicoSaved = complexoEolicoRepository.save(complexoEolico);

//        HashMap<String, MessageAttributeValue> messageAttribute = new HashMap();
//        messageAttribute.put("teste", new MessageAttributeValue().withStringValue("atributo").withDataType("String"));
//        SendMessageRequest request = new SendMessageRequest();
//        request.setQueueUrl("https://sqs.us-east-1.amazonaws.com/494945297464/PrimeiraFila");
//        request.setMessageBody(complexoEolicoSaved.toString());
//        request.setMessageAttributes(messageAttribute);
//
//        sqs.sendMessage(request);
        return complexoEolicoSaved;
    }

    @Override
    public ComplexoEolico getById(Long id) {
        return complexoEolicoRepository.findById(id).orElseThrow(ComplexoEolicoNotFound::new);
    }

    @Override
    public ComplexoEolico update(Long id, ComplexoEolico complexoEolico) {
        complexoEolico.setId(id);
        return complexoEolicoRepository.save(complexoEolico);
    }

    @Override
    public void delete(Long id) {
        complexoEolicoRepository.deleteById(id);
    }


//    @SqsListener("PrimeiraFila")
    public void listener(String message){
        System.out.println(message);
    }


    @SendTo("PrimeiraFila")
    public String sendMessage(ComplexoEolico complexoEolico){
        return complexoEolico.toString();
    }
}


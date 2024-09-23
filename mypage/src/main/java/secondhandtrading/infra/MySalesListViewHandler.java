package secondhandtrading.infra;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import secondhandtrading.config.kafka.KafkaProcessor;
import secondhandtrading.domain.*;

@Service
public class MySalesListViewHandler {

    //<<< DDD / CQRS
    @Autowired
    private MySalesListRepository mySalesListRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whenPostWrote_then_CREATE_1(@Payload PostWrote postWrote) {
        try {
            if (!postWrote.validate()) return;

            // view 객체 생성
            MySalesList mySalesList = new MySalesList();
            // view 객체에 이벤트의 Value 를 set 함
            mySalesList.setPostId(postWrote.getPostId());
            mySalesList.setUserId(Long.valueOf(postWrote.getUserId()));
            mySalesList.setCreateDt(postWrote.getCreateDt());
            mySalesList.setPrice(postWrote.getPrice());
            mySalesList.setStatus(postWrote.getStatus());
            // view 레파지 토리에 save
            mySalesListRepository.save(mySalesList);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenTradeEnded_then_UPDATE_1(@Payload TradeEnded tradeEnded) {
        try {
            if (!tradeEnded.validate()) return;
            // view 객체 조회

            List<MySalesList> mySalesListList = mySalesListRepository.findByPostId(
                tradeEnded.getPostId()
            );
            for (MySalesList mySalesList : mySalesListList) {
                // view 객체에 이벤트의 eventDirectValue 를 set 함
                mySalesList.setStatus(tradeEnded.getStatus());
                // view 레파지 토리에 save
                mySalesListRepository.save(mySalesList);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenPostHided_then_UPDATE_2(@Payload PostHided postHided) {
        try {
            if (!postHided.validate()) return;
            // view 객체 조회

            List<MySalesList> mySalesListList = mySalesListRepository.findByPostId(
                postHided.getPostId()
            );
            for (MySalesList mySalesList : mySalesListList) {
                // view 객체에 이벤트의 eventDirectValue 를 set 함
                mySalesList.setStatus(postHided.getStatus());
                // view 레파지 토리에 save
                mySalesListRepository.save(mySalesList);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenPostEdited_then_UPDATE_3(@Payload PostEdited postEdited) {
        try {
            if (!postEdited.validate()) return;
            // view 객체 조회

            List<MySalesList> mySalesListList = mySalesListRepository.findByPostId(
                postEdited.getPostId()
            );
            for (MySalesList mySalesList : mySalesListList) {
                // view 객체에 이벤트의 eventDirectValue 를 set 함
                mySalesList.setUpdateDt(postEdited.getUpdateDt());
                mySalesList.setPrice(postEdited.getPrice());
                // view 레파지 토리에 save
                mySalesListRepository.save(mySalesList);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenPostDeleted_then_DELETE_1(
        @Payload PostDeleted postDeleted
    ) {
        try {
            if (!postDeleted.validate()) return;
            // view 레파지 토리에 삭제 쿼리
            mySalesListRepository.deleteByPostId(postDeleted.getPostId());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //>>> DDD / CQRS
}

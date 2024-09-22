package secondhandtrading.infra;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;
import secondhandtrading.domain.*;

@Component
public class TradingHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<Trading>> {

    @Override
    public EntityModel<Trading> process(EntityModel<Trading> model) {
        return model;
    }
}

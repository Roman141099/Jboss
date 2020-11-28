package beans;

import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Random;

@Named("test")
@ConversationScoped
public class TestBean implements Serializable {
    private int num;
    private @Inject Conversation conversation;

    public int getNum() {
        if(num == 0)conversation.begin();
        if(num == 10)conversation.end();
        return num++;
    }
}

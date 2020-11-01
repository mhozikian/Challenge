package com.quasar.challenge.usecases;

        import static org.junit.Assert.assertEquals;
        import org.junit.Test;
        import org.junit.runner.RunWith;
        import org.mockito.InjectMocks;
        import org.mockito.junit.MockitoJUnitRunner;
        import java.util.ArrayList;

@RunWith(MockitoJUnitRunner.class)
public class GetMessageTest {

    @InjectMocks
    private GetMessageUseCase getMessage;

    @Test
    public void GetLocation_getLocation_ShouldReturnCoordinates() {
        ArrayList<String> kenobi = new ArrayList<>();
        kenobi.add("este");
        kenobi.add("es");
        kenobi.add("");
        kenobi.add("mensaje");
        kenobi.add("");
        ArrayList<String> skywalker = new ArrayList<>();
        skywalker.add("");
        skywalker.add("");
        skywalker.add("un");
        skywalker.add("mensaje");
        skywalker.add("");
        ArrayList<String> sato = new ArrayList<>();
        sato.add("este");
        sato.add("");
        sato.add("");
        sato.add("mensaje");
        sato.add("secreto");
        ArrayList<ArrayList<String>> list = new ArrayList<>();
        list.add(kenobi);
        list.add(skywalker);
        list.add(sato);
        assertEquals("este es un mensaje secreto", getMessage.getMessage(list));
    }
}
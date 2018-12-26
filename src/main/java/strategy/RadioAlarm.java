package strategy;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Evgeny Borisov
 */
@AllArgsConstructor
@NoArgsConstructor
@Setter
public class RadioAlarm implements Radio,Alarm {
    private Radio radio = new RadioImpl();
    private Alarm alarm = new AlarmImpl();


    @Override
    public void a() {
        this.radio.a();
    }

    @Override
    public void b() {
        this.radio.b();
    }

    @Override
    public void d() {
        this.alarm.d();
    }

    @Override
    public void c() {
        this.alarm.c();
    }
}

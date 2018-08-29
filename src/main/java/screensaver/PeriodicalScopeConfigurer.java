package screensaver;

import javafx.util.Pair;
import sun.reflect.generics.scope.Scope;

import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;

public class PeriodicalScopeConfigurer implements Scope {
    private Map<String, Pair<LocalTime, Object>> map = new HashMap<>();
    @Override
    public Object get(String name, ObjectFactory<?> objectFactory) {
        if (map.containsKey(name)) {
            Pair<LocalTime, Object> pair = map.get(name);
            int secondsSinceLastRequest = now().getSecond() - pair.getKey().getSecond();
            if (secondsSinceLastRequest > 3) {
                map.put(name ,  new Pair<>(now(), objectFactory.getObject()));
            }
        } else {
            map.put(name ,  new Pair<>(now(), objectFactory.getObject()));
        }
        return map.get(name).getValue();
    }
}

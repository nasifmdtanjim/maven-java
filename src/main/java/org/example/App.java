package org.example;

import java.util.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.example.io.User;

@Slf4j
public class App {

    private static final ObjectMapper mapper = new ObjectMapper();
    private static final User user = new User("Dan");

    public static final String ROLE_1 = "ROLE_1";

    public static final String ROLE_4 = "ROLE_4";
    public static final String ROLE_2 = "ROLE_2";

    static {
        user.setRoles(new HashSet<>(Arrays.asList(ROLE_1, ROLE_2, ROLE_4)));
    }

    public static void main(String[] args) {
        boolean allowed = allow("/partners/client/new");
        if (allowed) {
            log.info("Allowed");
        } else {
            log.warn("Not allowed");
        }
    }

    private static boolean allow(String url) {
        // from action table
        Map<String, Set<String>> pathRole = new HashMap<>();

        Set<String> set1 = new HashSet<>();
        set1.add(ROLE_1);
        set1.add(ROLE_2);

        Set<String> set2 = new HashSet<>();
        set2.add(ROLE_1);

        Set<String> set3 = new HashSet<>();

        pathRole.put(preparePath("/netcourier-data/partners/client?type=C&version=mafv2"), set1);
        pathRole.put(preparePath("/netcourier-data/booking-ng"), set2);
        pathRole.put(preparePath("/netcourier-data/partners/supplier"), set3);

//        log.info(getJson(pathRole));

        // from source
        Map<String, String> pathObjectType = new HashMap<>();

        pathObjectType.put(preparePath("/netcourier-data/partners/client"), "CL");
        pathObjectType.put(preparePath("/netcourier-data/booking-ng"), "CS");
        pathObjectType.put(preparePath("/netcourier-data/partners/supplier"), "SU");

//        log.info(getJson(pathObjectType));

        for (Map.Entry<String, Set<String>> entry : pathRole.entrySet()) {
            String path = entry.getKey();
            Set<String> roles = entry.getValue();
            if (url.contains(path)) {
                for (String ur : user.getRoles()) {
                    for (String rl : roles) {
                        if (rl.equals(ur)) {
                            return true;
                        }
                    }
                }
            }
        }

        return false;
    }

    @SneakyThrows
    private static String getJson(Object object) {
        return mapper.writerWithDefaultPrettyPrinter()
                .writeValueAsString(object);
    }

    private static String preparePath(String path) {
        int indexOfQuestionMark = path.indexOf('?');
        int end = indexOfQuestionMark != -1 ? indexOfQuestionMark : path.length();
        return path.substring(0, end)
                .replace("/netcourier-data", "")
                .replace("netcourier-data", "");
    }

}


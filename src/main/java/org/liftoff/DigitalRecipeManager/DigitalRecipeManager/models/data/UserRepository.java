//package org.liftoff.DigitalRecipeManager.DigitalRecipeManager.models.data;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//
//@Controller
//public class UserRepository {
//
//    @Autowired
//    UserRepository userRepository;
//
//
//    private static final String userSessionKey = "user";
//
//    public User getUserFromSession(HttpSession session) {
//        Integer userId = (Integer) session.getAttribute(userSessionKey);
//        if (userId == null) {
//            return null;
//        }
//
//        Optional<User> user = userRepository.findById(userId);
//
//        if (user.isEmpty()) {
//            return null;
//        }
//
//        return user.get();
//    }
//
//    private Optional<User> findById(Integer userId) {
//        return findById(userId);
//    }
//
//    private static void setUserInSession(HttpSession session, User user) {
//        session.setAttribute(userSessionKey, user.getId());
//    }
//}

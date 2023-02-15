//import by.it_academy.jd2.MJD29522.dao.api.IGenreDao;
//import by.it_academy.jd2.MJD29522.dao.api.ISingerDao;
//import by.it_academy.jd2.MJD29522.dao.api.IVoteDao;
//import by.it_academy.jd2.MJD29522.dao.orm.GenreDaoHibernate;
//import by.it_academy.jd2.MJD29522.dao.orm.Manager;
//import by.it_academy.jd2.MJD29522.dao.orm.SingerDaoHibernate;
//import by.it_academy.jd2.MJD29522.dao.orm.VoteDaoHibernate;
//import by.it_academy.jd2.MJD29522.dao.orm.api.IManager;
//import by.it_academy.jd2.MJD29522.dto.GenreDTO;
//import by.it_academy.jd2.MJD29522.dto.SingerDTO;
//import by.it_academy.jd2.MJD29522.dto.VoteDTO;
//import by.it_academy.jd2.MJD29522.service.GenreService;
//import by.it_academy.jd2.MJD29522.service.SingerService;
//import by.it_academy.jd2.MJD29522.service.StatisticService;
//import by.it_academy.jd2.MJD29522.service.VoteService;
//import by.it_academy.jd2.MJD29522.service.api.IGenreService;
//import by.it_academy.jd2.MJD29522.service.api.ISingerService;
//import by.it_academy.jd2.MJD29522.service.api.IStatisticService;
//import by.it_academy.jd2.MJD29522.service.api.IVoteService;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
//
//import java.time.LocalDateTime;
//import java.time.ZoneId;
//
//public class Main1 {
//    public static void main(String[] args) {
//        ApplicationContext context = new ClassPathXmlApplicationContext("main-context.xml");
//
//        ISingerDao singerDao = context.getBean("singerDaoHibernate", SingerDaoHibernate.class);
//        IGenreDao genreDao = context.getBean("genreDaoHibernate", GenreDaoHibernate.class);
//        IVoteDao voteDao = context.getBean("voteDaoHibernate", VoteDaoHibernate.class);
//
//        ISingerService singerService = context.getBean("singerService", SingerService.class);
//        IGenreService genreService = context.getBean("genreService", GenreService.class);
//        IVoteService voteService = context.getBean("voteService", VoteService.class);
//        IStatisticService statisticService = context.getBean("statisticService", StatisticService.class);
//
////        SingerDTO leontiev = new SingerDTO("Леонтьев");
//        GenreDTO genre = new GenreDTO("rnb");
//
//       // singerService.add("Леонтьев");
//        genreService.add(genre);
//
//        VoteDTO voteDTO1 = new VoteDTO(2,new long[]{1, 2 , 5}, "Message14022023", "ufdddl@mail.ru", LocalDateTime.now());
//
//        voteService.save(voteDTO1);
//
//        System.out.println(singerDao.get());
//        System.out.println(genreDao.get());
//
//
//        System.out.println(voteService.getVote());
//        System.out.println("========================================================");
//        System.out.println(statisticService.getResultSinger());
//        System.out.println(statisticService.getResultGenre());
//        System.out.println(statisticService.getResultMessage());
//
//
//    }
//
//}
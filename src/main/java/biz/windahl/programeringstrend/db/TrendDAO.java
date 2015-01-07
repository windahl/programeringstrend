package biz.windahl.programeringstrend.db;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;

import java.time.LocalDate;


public interface TrendDAO {
    @SqlUpdate("insert into trend (language_id, region_id, date, no_of_jobs) values (:languageId, :regionId, :date, :noOfJobs)")
    void insert(@Bind("languageId") int languageId, @Bind("regionId") int regionId, @Bind("date") LocalDate localDate, @Bind("noOfJobs") int noOfJobs);

    @SqlQuery("select name from something where id = :id")
    String findByDay(@Bind("id") int id);

    @SqlQuery("select min(date) from trend")
    LocalDate findFirstDate();

}

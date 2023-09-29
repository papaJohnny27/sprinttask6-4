package domain;


import domain.language.Language;
import domain.news.News;
import java.sql.Connection;
import java.sql.DriverManager;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Properties;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Database {
    private static Connection connection;
    private static final String URL = "jdbc:postgresql://localhost:5432/javaee_sprint6_4";
    private static final String USER = "postgres";
    private static final String PASSWORD = "eldos";

    static {
        try {
            Class.forName("org.postgresql.Driver");
            Properties props = new Properties();
            props.setProperty("user", USER);
            props.setProperty("password", PASSWORD);
            connection = DriverManager.getConnection(URL,props);

            System.out.println("Successfully connected to database");
        }catch (Exception e){
            System.out.println("Failed to connect to database");
        }
    }
    public static void addNews(String title, String content, Long languageId, LocalDate postDate) {
        try (PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO news VALUES (default, ?, ?, ?, ?);")) {
            preparedStatement.setString(1, title);
            preparedStatement.setString(2, content);
            preparedStatement.setLong(3, languageId);
            preparedStatement.setDate(4, Date.valueOf(postDate));

            preparedStatement.executeUpdate();
        } catch (Exception e) {
            System.out.println("Failed to insert new news: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static News getNewsById(Long id){
        try (PreparedStatement preparedStatement = connection.prepareStatement("SELECT * from news WHERE id = ?;")){
            preparedStatement.setLong(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Long newsId = resultSet.getLong("id");
                String title = resultSet.getString("title");
                String content = resultSet.getString("content");
                Long languageId = resultSet.getLong("language_id");
                LocalDate postdate = resultSet.getDate("post_date").toLocalDate();

                return new News(newsId,title,content,languageId,postdate);
            }
        }catch (Exception e) {
            e.printStackTrace();
            System.out.println("Failed to get news by id: " + id);
        }
        return null;
    }

    public static List<News> getAllNews() {
        ArrayList<News> news = new ArrayList<>();

        try (PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM news;")) {
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Long id = resultSet.getLong("id");
                String title = resultSet.getString("title");
                String content = resultSet.getString("content");
                Long languageId = resultSet.getLong("language_id");
                LocalDate postDate = resultSet.getDate("post_date").toLocalDate();

                news.add(new News(id, title, content, languageId, postDate));
            }
        } catch (Exception e) {
            System.out.println("Failed to get all news");
        }

        return news;
    }

    public static List<News> getAllNewsByLanguageId(Long languageId) {
        ArrayList<News> news = new ArrayList<>();

        try (PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM news WHERE language_id = ?;")) {
            preparedStatement.setLong(1, languageId);
            ResultSet resultSet = preparedStatement.executeQuery();


            while (resultSet.next()) {
                Long id = resultSet.getLong("id");
                String title = resultSet.getString("title");
                String content = resultSet.getString("content");
                Long newLanguageId = resultSet.getLong("language_id");
                LocalDate postDate = resultSet.getDate("post_date").toLocalDate();

                news.add(new News(id, title, content, newLanguageId, postDate));
            }
        } catch (Exception e) {
            System.out.println("Failed to get all news");
        }

        return news;
    }

    public static Language getLanguageById(Long id) {
        try (PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM language WHERE id = ?;")) {
            preparedStatement.setLong(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Long languageId = resultSet.getLong("id");
                String code = resultSet.getString("code");

                return new Language(languageId, code);
            }
        } catch (Exception e) {
            System.out.println("Failed to get language by id: " + e.getMessage());
        }

        return null;
    }

    public static Language getLanguageByCode(String code) {
        try (PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM language WHERE code = ?;")) {
            preparedStatement.setString(1, code);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Long languageId = resultSet.getLong("id");
                String languageCode = resultSet.getString("code");

                return new Language(languageId, languageCode);
            }
        } catch (Exception e) {
            System.out.println("Failed to get language by id: " + e.getMessage());
        }

        return null;
    }

    public static void updateNews(Long id,String title,String content,
                                  Long languageId, LocalDate postDate){
        try (PreparedStatement preparedStatement = connection.prepareStatement("update news set title=?,content=?,language_id=?,post_date=? where id=?;")) {
            preparedStatement.setString(1,title);
            preparedStatement.setString(2,content);
            preparedStatement.setLong(3,languageId);
            preparedStatement.setDate(4,Date.valueOf(postDate));
            preparedStatement.setLong(5,id);
            preparedStatement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Failed to update news by id: " + e.getMessage());
        }


    }

    public static void deleteNews(Long id){
        try (PreparedStatement preparedStatement = connection.prepareStatement("delete from news where id=?")){
            preparedStatement.setLong(1,id);
            preparedStatement.executeUpdate();
        }catch (Exception e) {
            e.printStackTrace();
            System.out.println("Failed to delete news by id" +e.getMessage());
        }
    }
}


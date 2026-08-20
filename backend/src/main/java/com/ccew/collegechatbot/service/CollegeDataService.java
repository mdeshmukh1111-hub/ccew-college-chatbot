package com.ccew.collegechatbot.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
public class CollegeDataService {

    private JsonNode collegeData;

    public CollegeDataService() {

        try {

            ObjectMapper mapper = new ObjectMapper();

            File file = new File("../data/college-info.json");

            collegeData = mapper.readTree(file);

            System.out.println("=================================");
            System.out.println("College knowledge base loaded!");
            System.out.println("=================================");

        } catch (Exception e) {

            System.out.println("=================================");
            System.out.println("ERROR: Could not load college-info.json");
            System.out.println("=================================");

            e.printStackTrace();
        }
    }


    public String search(String question) {

        if (collegeData == null) {

            return "Sorry, I could not load the college information.";
        }

        String text = question.toLowerCase();


        // GREETING

        if (text.contains("hello")
                || text.contains("hi")
                || text.contains("hey")) {

            return "Hello! 👋 I am the CCEW College Assistant. How can I help you?";
        }


        // COURSES / PROGRAMMES

        if (text.contains("course")
                || text.contains("courses")
                || text.contains("programme")
                || text.contains("program")) {

            JsonNode programmes = collegeData.get("programmes");

            return "CCEW offers "
                    + programmes.get("undergraduate")
                    .get("degree").asText()
                    + " at undergraduate level, "
                    + programmes.get("postgraduate")
                    .get("degree").asText()
                    + " at postgraduate level, and "
                    + programmes.get("doctoral")
                    .get("degree").asText()
                    + " in "
                    + programmes.get("doctoral")
                    .get("specialization").asText()
                    + ".";
        }


        // DEPARTMENTS

        if (text.contains("department")
                || text.contains("departments")
                || text.contains("branch")
                || text.contains("branches")
                || text.contains("stream")
                || text.contains("streams")) {

            StringBuilder answer = new StringBuilder();

            answer.append("CCEW has the following departments:\n");

            JsonNode departments = collegeData.get("departments");

            for (JsonNode department : departments) {

                answer.append("• ")
                      .append(department.get("name").asText())
                      .append("\n");
            }

            return answer.toString();
        }


        // FACILITIES

        if (text.contains("facility")
                || text.contains("facilities")
                || text.contains("infrastructure")) {

            StringBuilder answer = new StringBuilder();

            answer.append("CCEW provides facilities such as:\n");

            JsonNode facilities = collegeData.get("facilities");

            for (JsonNode facility : facilities) {

                answer.append("• ")
                      .append(facility.asText())
                      .append("\n");
            }

            return answer.toString();
        }


        // PLACEMENTS

        if (text.contains("placement")
                || text.contains("placements")
                || text.contains("job")
                || text.contains("jobs")) {

            JsonNode placement = collegeData.get("placements");

            return placement.get("description").asText()
                    + " "
                    + placement.get("training").asText();
        }


        // ADMISSIONS

        if (text.contains("admission")
                || text.contains("admissions")
                || text.contains("apply")
                || text.contains("application")) {

            JsonNode admission = collegeData.get("admissions");

            return admission.get("information").asText();
        }


        // ABOUT COLLEGE

        if (text.contains("about")
                || text.contains("college")
                || text.contains("ccew")) {

            JsonNode college = collegeData.get("college");

            return college.get("name").asText()
                    + " is located in "
                    + college.get("location").asText()
                    + ".";
        }


        return "I couldn't find that information in my current CCEW knowledge base. Try asking about courses, departments, admissions, placements or facilities.";
    }
}
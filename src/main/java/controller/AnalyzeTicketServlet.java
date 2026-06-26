package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import model.TicketResponse;
import service.TicketAnalysisService;
import com.google.gson.Gson;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import model.TicketRequest;

@WebServlet("/analyze-ticket")
public class AnalyzeTicketServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        BufferedReader reader = request.getReader();

        Gson gson = new Gson();

        TicketRequest ticket = gson.fromJson(reader, TicketRequest.class);
        TicketAnalysisService service = new TicketAnalysisService();

        TicketResponse result = service.analyze(ticket);

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        PrintWriter out = response.getWriter();


        out.print(gson.toJson(result));

        out.flush();
    }
}
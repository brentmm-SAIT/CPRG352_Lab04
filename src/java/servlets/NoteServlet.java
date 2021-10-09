package servlets;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Note;

public class NoteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

        String path = getServletContext().getRealPath("/WEB-INF/note.txt");

        // to read files
        BufferedReader br = new BufferedReader(new FileReader(new File(path)));

        String title = "";
        String contents = "";

        title = br.readLine();
//        System.out.print(title);
        contents = br.readLine();
//        System.out.print(contents);

        Note noteContents = new Note(title, contents);

        request.setAttribute("note", noteContents);

        if (request.getQueryString() != null) {
            if (request.getQueryString().equals("edit")) {
                getServletContext().getRequestDispatcher("/WEB-INF/editnote.jsp").forward(request, response);
            }
        }

        getServletContext().getRequestDispatcher("/WEB-INF/viewnote.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

        String title = "";
        String contents = "";

        title = request.getParameter("title");
        contents = request.getParameter("contents");

        Note noteContents = new Note(title, contents);

        String path = getServletContext().getRealPath("/WEB-INF/note.txt");

        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(path, false)));
            pw.println(title);
            pw.println(contents);
            pw.close();
        

        request.setAttribute("note", noteContents);

        // validation: if the parameters don't exist or are empty, show the first page again.
        if (title == null || title.equals("") || contents == null || contents.equals("")) {
            // display the form again.
            getServletContext().getRequestDispatcher("/WEB-INF/editnote.jsp").forward(request, response);
            // after we load a JSP, use a return statement.
            // stop the code from executing (VERY IMPORTANT!)
            return;
        }

        getServletContext().getRequestDispatcher("/WEB-INF/viewnote.jsp").forward(request, response);

    }

}

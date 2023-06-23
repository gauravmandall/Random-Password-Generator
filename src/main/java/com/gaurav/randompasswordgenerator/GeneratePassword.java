package com.gaurav.randompasswordgenerator;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.SecureRandom;

@WebServlet("/GeneratePassword")
public class GeneratePassword extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final String UPPER = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String LOWER = "abcdefghijklmnopqrstuvwxyz";
    private static final String DIGITS = "0123456789";
    private static final String SPECIAL = "~`!@#$%^&* ()-_=+ [ {]}\\|;:'\",<.>/?";

    public GeneratePassword() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><head><title>Random Password Generator</title></head><body>");
        out.println("<h1>Random Password Generator</h1>");

        try {
            int length = Integer.parseInt(request.getParameter("length"));
            boolean upper = request.getParameter("uppercase") != null;
            boolean lower = request.getParameter("lowercase") != null;
            boolean digits = request.getParameter("digits") != null;
            boolean special = request.getParameter("special") != null;

            if (length < 8 || length > 32) {
                out.println("<p>Invalid password length. Please enter a number between 8 and 32.</p>");
            } else if (!upper && !lower && !digits && !special) {
                out.println("<p>Please select at least one character set.</p>");
            } else {
                String password = generatePassword(length, upper, lower, digits, special);
                out.println("<p>Your random password is: <b>" + password + "</b></p>");
                out.println("<p><button onclick=\"window.location.href='index.jsp';\">Back</button></p>");
            }
        } catch (NumberFormatException e) {
            out.println("<p>Invalid password length. Please enter a number between 8 and 32.</p>");
        }

        out.println("</body></html>");
    }

    private String generatePassword(int length, boolean upper, boolean lower, boolean digits, boolean special) {
        SecureRandom random = new SecureRandom();
        StringBuilder sb = new StringBuilder();

        String charset = "";
        if (upper) charset += UPPER;
        if (lower) charset += LOWER;
        if (digits) charset += DIGITS;
        if (special) charset += SPECIAL;

        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(charset.length());
            char randomChar = charset.charAt(randomIndex);
            sb.append(randomChar);
        }

        return sb.toString();
    }
}

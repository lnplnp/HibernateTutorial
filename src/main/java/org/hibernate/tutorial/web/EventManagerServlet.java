package org.hibernate.tutorial.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.tutorial.domain.Event;
import org.hibernate.tutorial.util.HibernateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SuppressWarnings("serial")
public class EventManagerServlet extends HttpServlet {

  private static Logger log = LoggerFactory.getLogger(EventManagerServlet.class);

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    log.debug("");

    log.info("*** doGet {}", request);

    SimpleDateFormat dateFormatter = new SimpleDateFormat("dd.MM.yyyy");

    try {
      // Begin unit of work
      HibernateUtil.getSessionFactory().getCurrentSession().beginTransaction();

      // Process request and render page...
      // Write HTML header
      PrintWriter out = response.getWriter();
      out.println("<html><head><title>Event Manager</title></head><body>");

      out.println("<p>" + System.getProperty("user.dir") + "</p>");
      out.println("<p>" + getServletContext().getServletContextName() + "</p>");

      // Handle actions
      if ("store".equals(request.getParameter("action"))) {

        String eventTitle = request.getParameter("eventTitle");
        String eventDate = request.getParameter("eventDate");

        if ("".equals(eventTitle) || "".equals(eventDate)) {
          out.println("<b><i>Please enter event title and date.</i></b>");
        } else {
          createAndStoreEvent(eventTitle, dateFormatter.parse(eventDate));
          out.println("<b><i>Added event.</i></b>");
        }
      }

      // Print page
      printEventForm(out);
      listEvents(out, dateFormatter);

      // Write HTML footer
      out.println("</body></html>");
      out.flush();
      out.close();

      // End unit of work
      HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().commit();
    } catch (Exception ex) {
      HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().rollback();
      if (ServletException.class.isInstance(ex)) {
        throw (ServletException) ex;
      } else {
        throw new ServletException(ex);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private void listEvents(PrintWriter out, SimpleDateFormat dateFormatter) {
    log.debug("");

    List<Event> result = HibernateUtil.getSessionFactory().getCurrentSession().createCriteria(Event.class).list();
    if (result.size() > 0) {
      out.println("<h2>Events in database:</h2>");
      out.println("<table style=\"border:1px solid black\">");
      out.println("<tr>");
      out.println("<th>Event title</th>");
      out.println("<th>Event date</th>");
      out.println("</tr>");
      Iterator<Event> it = result.iterator();
      Random rand = new Random();
      while (it.hasNext()) {
        Event event = (Event) it.next();
        String color = "rgb(" + rand.nextInt(255) + "," + rand.nextInt(255) + "," + rand.nextInt(255) + ")";
        out.println("<tr>");
        out.println("<td style=\"border:1px solid " + color + "\">" + event.getTitle() + "</td>");
        out.println("<td style=\"border:1px solid " + color + "\">" + dateFormatter.format(event.getDate()) + "</td>");
        out.println("</tr>");
      }
      out.println("</table>");
    }
  }

  private void printEventForm(PrintWriter out) {
    log.debug("");
    out.println("<h2>Add new event:</h2>");
    out.println("<form>");
    out.println("Title: <input name='eventTitle' length='50'/><br/>");
    out.println("Date (e.g. 24.12.2009): <input name='eventDate' length='10'/><br/>");
    out.println("<input type='submit' name='action' value='store'/>");
    out.println("</form>");
  }

  protected void createAndStoreEvent(String title, Date theDate) {
    log.debug("");
    Event theEvent = new Event();
    theEvent.setTitle(title);
    theEvent.setDate(theDate);

    HibernateUtil.getSessionFactory().getCurrentSession().save(theEvent);
  }

}

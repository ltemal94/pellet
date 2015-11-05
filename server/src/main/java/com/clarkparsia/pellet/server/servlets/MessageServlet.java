package com.clarkparsia.pellet.server.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.clarkparsia.pellet.json.GenericJsonMessage;

/**
 * @author Edgar Rodriguez-Diaz
 */
public class MessageServlet extends HttpServlet {

	private static final String MESSAGE_PARAM = "message";

	private GenericJsonMessage message;

	@Override
	public void init(final ServletConfig config) throws ServletException {
		super.init(config);
		message = new GenericJsonMessage(config.getInitParameter(MESSAGE_PARAM));
	}

	@Override
	protected void doGet(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType(message.getMimeType());

		PrintWriter writer = resp.getWriter();
		writer.write(message.toJsonString());
		writer.close();
	}

	@Override
	protected void doPost(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException,
	                                                                                           IOException {
		doGet(req, resp);
	}
}

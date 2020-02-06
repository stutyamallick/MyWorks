package com.avaya.ngm.util;

import org.aspectj.lang.JoinPoint;
import org.slf4j.Logger;
import org.slf4j.MDC;

import com.google.gson.Gson;

public class UtilLogger {

	public static void auditLogger(Logger logger, JoinPoint joinPoint, String flag, String message) {

		Gson gson = new Gson();
		
		try {
			MDC.put("level", "audit");
			MDC.put("user_id", "Test_User");
			MDC.put("tenant_id", "Test_Tenant");
			MDC.put("audit_action", "Test_Tenant");//CREATE
			MDC.put("audit_object_type", "Test_Tenant"); // USER
			MDC.put("audit_object_id", "ObjectID"); // USER NAME
			//MDC.put("audit_action_message", "Test_Tenant_Message");
			switch (flag) {
			case "ORIGINAL":
				MDC.put("audit_action_data", "{ original: {" + gson.toJson(joinPoint.getArgs().toString()) + "}, new: {},  changed: {} }");
				break;
			case "NEW":
				MDC.put("audit_action_data", "{ original: {}, new: {" + gson.toJson(joinPoint.getArgs().toString()) + "},  changed: {} }");
				break;
			case "CHANGED":
				MDC.put("audit_action_data", "{ original: {}, new: {},  changed: {" + gson.toJson(joinPoint.getArgs().toString()) + "} }");
				break;
			default:
				MDC.put("audit_action_data", "{ original: {}, new: {},  changed: {} }");
				break;
			}
			logger.info(message);
		} finally {
			MDC.clear();
		}
	}

	public static void genericLogger(Logger logger) {
		try {
			MDC.put("user_id", "Test_User_Id");
			MDC.put("tenant_id", "Test_Tenant_Id");
			MDC.put("log_message", "Log_Message");
			MDC.put("parameters", "{}");
			logger.info("ServiceLayerAspectGeneric");
		} finally {
			MDC.clear();
		}
	}
}

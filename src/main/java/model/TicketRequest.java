package model;

import java.util.List;

public class TicketRequest {
	private String ticket_id;
	private String relevant_transaction_id;
	private String evidence_verdict;
	private String case_type;
	private String severity;
	private String department;
	private String agent_summary;
	private String recommended_next_action;
	private String customer_reply;
	private boolean human_review_required;
	public String getRelevant_transaction_id() {
		return relevant_transaction_id;
	}

	public void setRelevant_transaction_id(String relevant_transaction_id) {
		this.relevant_transaction_id = relevant_transaction_id;
	}

	public String getEvidence_verdict() {
		return evidence_verdict;
	}

	public void setEvidence_verdict(String evidence_verdict) {
		this.evidence_verdict = evidence_verdict;
	}

	public String getCase_type() {
		return case_type;
	}

	public void setCase_type(String case_type) {
		this.case_type = case_type;
	}

	public String getSeverity() {
		return severity;
	}

	public void setSeverity(String severity) {
		this.severity = severity;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getAgent_summary() {
		return agent_summary;
	}

	public void setAgent_summary(String agent_summary) {
		this.agent_summary = agent_summary;
	}

	public String getRecommended_next_action() {
		return recommended_next_action;
	}

	public void setRecommended_next_action(String recommended_next_action) {
		this.recommended_next_action = recommended_next_action;
	}

	public String getCustomer_reply() {
		return customer_reply;
	}

	public void setCustomer_reply(String customer_reply) {
		this.customer_reply = customer_reply;
	}

	public boolean isHuman_review_required() {
		return human_review_required;
	}

	public void setHuman_review_required(boolean human_review_required) {
		this.human_review_required = human_review_required;
	}

	public double getConfidence() {
		return confidence;
	}

	public void setConfidence(double confidence) {
		this.confidence = confidence;
	}

	public List<String> getReason_codes() {
		return reason_codes;
	}

	public void setReason_codes(List<String> reason_codes) {
		this.reason_codes = reason_codes;
	}

	private double confidence;
	private List<String> reason_codes;
    private String complaint;
    private String language;
    private String channel;
    private String user_type;
    private String campaign_context;

    private List<Transaction> transaction_history;

    public TicketRequest() {
    }

    public String getTicket_id() {
        return ticket_id;
    }

    public void setTicket_id(String ticket_id) {
        this.ticket_id = ticket_id;
    }

    public String getComplaint() {
        return complaint;
    }

    public void setComplaint(String complaint) {
        this.complaint = complaint;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getUser_type() {
        return user_type;
    }

    public void setUser_type(String user_type) {
        this.user_type = user_type;
    }

    public String getCampaign_context() {
        return campaign_context;
    }

    public void setCampaign_context(String campaign_context) {
        this.campaign_context = campaign_context;
    }

    public List<Transaction> getTransaction_history() {
        return transaction_history;
    }

    public void setTransaction_history(List<Transaction> transaction_history) {
        this.transaction_history = transaction_history;
    }
}
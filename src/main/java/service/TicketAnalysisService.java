package service;

import java.util.ArrayList;
import java.util.List;

import model.TicketRequest;
import model.TicketResponse;
import model.Transaction;

public class TicketAnalysisService {

    public TicketResponse analyze(TicketRequest ticket) {

        TicketResponse response = new TicketResponse();

        // Ticket ID
        response.setTicket_id(ticket.getTicket_id());

        // Default values
        response.setRelevant_transaction_id(null);
        response.setEvidence_verdict("insufficient_data");
        response.setHuman_review_required(false);
        response.setConfidence(0.60);

        List<String> reasonCodes = new ArrayList<>();

        String complaint = ticket.getComplaint().toLowerCase();

        // Find first transaction (temporary logic)
        Transaction matchedTransaction = null;

        if (ticket.getTransaction_history() != null
                && !ticket.getTransaction_history().isEmpty()) {

            matchedTransaction = ticket.getTransaction_history().get(0);

            response.setRelevant_transaction_id(
                    matchedTransaction.getTransaction_id());

            response.setEvidence_verdict("consistent");
        }

        // Wrong Transfer
        if (complaint.contains("wrong number")
                || complaint.contains("wrong transfer")) {

            response.setCase_type("wrong_transfer");
            response.setSeverity("high");
            response.setDepartment("dispute_resolution");

            response.setAgent_summary(
                    "Customer reported money sent to the wrong recipient.");

            response.setRecommended_next_action(
                    "Verify the transaction and escalate to dispute resolution.");

            response.setCustomer_reply(
                    "We have received your complaint. Our team will review your request.");

            response.setHuman_review_required(true);
            response.setConfidence(0.95);

            reasonCodes.add("wrong_transfer");

        }

        // Refund
        else if (complaint.contains("refund")) {

            response.setCase_type("refund_request");
            response.setSeverity("medium");
            response.setDepartment("refund_team");

            response.setAgent_summary(
                    "Customer requested a refund.");

            response.setRecommended_next_action(
                    "Verify eligibility and initiate refund review.");

            response.setCustomer_reply(
                    "Your refund request has been received.");

            response.setConfidence(0.90);

            reasonCodes.add("refund");

        }

        // Fraud
        else if (complaint.contains("fraud")
                || complaint.contains("scam")
                || complaint.contains("unauthorized")) {

            response.setCase_type("phishing_or_social_engineering");
            response.setSeverity("critical");
            response.setDepartment("fraud_risk");

            response.setAgent_summary(
                    "Customer reported suspicious or unauthorized activity.");

            response.setRecommended_next_action(
                    "Freeze account if necessary and escalate immediately.");

            response.setCustomer_reply(
                    "We have received your report. Please do not share your OTP, PIN, or password with anyone.");

            response.setHuman_review_required(true);
            response.setConfidence(0.98);

            reasonCodes.add("fraud");

        }

        // Payment Failed
        else if (complaint.contains("payment failed")
                || complaint.contains("transaction failed")) {

            response.setCase_type("payment_failure");
            response.setSeverity("medium");
            response.setDepartment("payment_support");

            response.setAgent_summary(
                    "Customer reported a failed payment.");

            response.setRecommended_next_action(
                    "Verify payment gateway logs.");

            response.setCustomer_reply(
                    "We are checking your payment status.");

            response.setConfidence(0.88);

            reasonCodes.add("payment_failure");

        }

        // Account Blocked
        else if (complaint.contains("account blocked")
                || complaint.contains("account locked")) {

            response.setCase_type("account_access");
            response.setSeverity("high");
            response.setDepartment("account_support");

            response.setAgent_summary(
                    "Customer cannot access the account.");

            response.setRecommended_next_action(
                    "Verify customer identity and unlock account.");

            response.setCustomer_reply(
                    "Your account issue has been forwarded to our support team.");

            response.setHuman_review_required(true);
            response.setConfidence(0.92);

            reasonCodes.add("account_access");

        }

        // Login
        else if (complaint.contains("login")) {

            response.setCase_type("login_issue");
            response.setSeverity("medium");
            response.setDepartment("technical_support");

            response.setAgent_summary(
                    "Customer reported login issues.");

            response.setRecommended_next_action(
                    "Check authentication service.");

            response.setCustomer_reply(
                    "Our technical team is investigating your login problem.");

            response.setConfidence(0.85);

            reasonCodes.add("login_issue");

        }

        // KYC
        else if (complaint.contains("kyc")
                || complaint.contains("verification")) {

            response.setCase_type("kyc_verification");
            response.setSeverity("medium");
            response.setDepartment("verification_team");

            response.setAgent_summary(
                    "Customer needs KYC verification.");

            response.setRecommended_next_action(
                    "Verify submitted documents.");

            response.setCustomer_reply(
                    "Your verification request is under review.");

            response.setConfidence(0.87);

            reasonCodes.add("kyc");

        }

        // Balance
        else if (complaint.contains("balance")) {

            response.setCase_type("balance_issue");
            response.setSeverity("medium");
            response.setDepartment("account_support");

            response.setAgent_summary(
                    "Customer reported an incorrect balance.");

            response.setRecommended_next_action(
                    "Verify recent transactions.");

            response.setCustomer_reply(
                    "We are checking your account balance.");

            response.setConfidence(0.84);

            reasonCodes.add("balance");

        }

        // Default
        else {

            response.setCase_type("general_query");
            response.setSeverity("low");
            response.setDepartment("customer_support");

            response.setAgent_summary(
                    "General customer inquiry.");

            response.setRecommended_next_action(
                    "Assign to customer support.");

            response.setCustomer_reply(
                    "Thank you. Your complaint has been received.");

            response.setConfidence(0.70);

            reasonCodes.add("general");

        }

        if (matchedTransaction != null) {
            reasonCodes.add("transaction_match");
        }

        response.setReason_codes(reasonCodes);

        return response;
    }

}
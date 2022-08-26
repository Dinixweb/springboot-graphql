package io.dinixweb.SpringbootgraphQL.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GlobalResponse {
    private boolean success;
    private String error;
    private long studentId;
}

@Data
@AllArgsConstructor
@NoArgsConstructor
class UpdateResponse{
    private boolean success;
    private String firstName;
    private String lastName;
    private String studentId;
    private String grade;
    private String error;
}


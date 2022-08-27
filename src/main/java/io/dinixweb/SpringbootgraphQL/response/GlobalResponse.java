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


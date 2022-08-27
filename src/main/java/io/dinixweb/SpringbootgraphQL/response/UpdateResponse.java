package io.dinixweb.SpringbootgraphQL.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class UpdateResponse {
    private boolean success;
    private long studentId;
    private String error;
}

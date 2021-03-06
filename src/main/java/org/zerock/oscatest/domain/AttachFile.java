package org.zerock.oscatest.domain;

import lombok.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class AttachFile {
    private String uuid;
    private Integer conNo;
    private String fileName;
    private String savePath;
    private boolean img;
}

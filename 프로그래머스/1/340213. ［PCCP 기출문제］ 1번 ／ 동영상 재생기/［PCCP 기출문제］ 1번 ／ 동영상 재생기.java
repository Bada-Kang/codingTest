class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        int int_video_len = Integer.parseInt(video_len.split(":")[0]) * 60 + Integer.parseInt(video_len.split(":")[1]);
        int int_pos = Integer.parseInt(pos.split(":")[0]) * 60 + Integer.parseInt(pos.split(":")[1]);
        int int_op_start = Integer.parseInt(op_start.split(":")[0]) * 60 + Integer.parseInt(op_start.split(":")[1]);
        int int_op_end = Integer.parseInt(op_end.split(":")[0]) * 60 + Integer.parseInt(op_end.split(":")[1]);

        int answer = int_pos;
        if (answer >= int_op_start && answer <= int_op_end) {
            answer = int_op_end;
        }
        for (String command : commands) {
            if (command.equals("prev")) {
                if (answer < 10) {
                    answer = 0;
                } else {
                    answer -= 10;
                }
            } else if (command.equals("next")) {
                if (answer > int_video_len - 10) {
                    answer = int_video_len;
                } else {
                    answer += 10;
                }
            }
            if (answer >= int_op_start && answer <= int_op_end) {
                answer = int_op_end;
            }
        }
        String str_min = "";
        String str_sec = "";
        if (answer/60 < 10) {
            str_min = "0" + Integer.toString(answer/60);
        } else {
            str_min = Integer.toString(answer/60);
        }

        if (answer%60 < 10) {
            str_sec = "0" + Integer.toString(answer%60);
        } else {
            str_sec = Integer.toString(answer%60);
        }

        return str_min + ":" + str_sec;
    }
}
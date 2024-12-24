package app.tarot.be.type;


import app.tarot.be.response.EnumResponse;
import app.tarot.be.util.CommonUtil;
import lombok.Getter;

@Getter
public enum RegisterProcessType {
    NEW(1, "New"),
    REVIEW_CV(2, "Review CV"),
    TEST_EXAM(3, "Test Exam"),

    INTERVIEW(4, "Interview"),
    FINAL_REVIEW(5, "Final Review"),
    ;
    private final Integer id;
    private final String name;

    RegisterProcessType(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public static EnumResponse getInstance(Integer type) {
        if (CommonUtil.isEmpty(type)) return null;
        for (var value : RegisterProcessType.values()) {
            if (value.id == type) {
                return new EnumResponse(value.getId(), value.getName());
            }
        }
        return null;
    }
    public static RegisterProcessType fromName(String name) {
        if (CommonUtil.isEmpty(name)) return null;
        for (var value : RegisterProcessType.values()) {
            if (value.name.equalsIgnoreCase(name)) { // So sánh không phân biệt hoa thường
                return value;
            }
        }
        return null; // Trả về null nếu không tìm thấy
    }
}

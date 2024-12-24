package app.tarot.be.type;


import app.tarot.be.response.EnumResponse;
import app.tarot.be.util.CommonUtil;
import lombok.Getter;

@Getter
public enum RegisterReaderStatusType {
    IN_PREVIEW(1, "In Preview"),
    REJECT(2, "Reject"),
    APPROVED(3, "Approved")
    ;
    private final Integer id;
    private final String name;

    RegisterReaderStatusType(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public static EnumResponse getInstance(Integer type) {
        if (CommonUtil.isEmpty(type)) return null;
        for (var value : RegisterReaderStatusType.values()) {
            if (value.id == type) {
                return new EnumResponse(value.getId(), value.getName());
            }
        }
        return null;
    }
    public static RegisterReaderStatusType fromName(String name) {
        if (CommonUtil.isEmpty(name)) return null;
        for (var value : RegisterReaderStatusType.values()) {
            if (value.name.equalsIgnoreCase(name)) { // So sánh không phân biệt hoa thường
                return value;
            }
        }
        return null; // Trả về null nếu không tìm thấy
    }
}

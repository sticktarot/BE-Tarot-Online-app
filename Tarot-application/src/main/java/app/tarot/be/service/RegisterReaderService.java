package app.tarot.be.service;

import app.tarot.be.request.RegisterReaderRequest;
import app.tarot.be.response.RegisterReaderResponse;

public interface RegisterReaderService {
    RegisterReaderResponse createRegisterReaderForm(RegisterReaderRequest readerRequest);
}

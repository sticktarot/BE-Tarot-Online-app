package app.tarot.be.service;

import app.tarot.be.request.RegisterReaderRequest;
import app.tarot.be.response.registerReader.RegisterReaderResponse;

public interface RegisterReaderService {


    RegisterReaderResponse createRegisterReaderForm(RegisterReaderRequest readerRequest);

    RegisterReaderResponse updateRegisterReaderForm(RegisterReaderRequest readerRequest);


}

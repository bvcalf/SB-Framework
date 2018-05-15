package com.bvcalf.beans.io;

import java.io.IOException;
import java.io.InputStream;

/**
 * Resource是spring内部定位资源的接口。
 */
public interface Resource {

    /**
     * 获取输入流
     * @return
     * @throws IOException
     */
    InputStream getInputStream() throws IOException;

}

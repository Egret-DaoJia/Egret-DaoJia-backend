package main

import (
	"fmt"
	"io/ioutil"
	"net/http"
	"sync"
	"time"
)

const (
	url         = "http://localhost:33500/edj-foundations/test/hello" // 压测的 URL
	numRequests = 10                                                  // 并发请求数
)

// 自定义请求函数，支持添加请求头和请求体
func makeRequest(wg *sync.WaitGroup) {
	defer wg.Done()

	// 创建请求
	req, err := http.NewRequest("GET", url, nil)
	if err != nil {
		fmt.Println("Error creating request:", err)
		return
	}

	// 添加自定义请求头
	req.Header.Set("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/129.0.0.0 Safari/537.36 Edg/129.0.0.0")
	req.Header.Set("AuthorizationAccessToken", "eyJhbGciOiJIbWFjU0hBMjU2IiwidHlwIjoiSldUIn0.eyJpZCI6MSwiZXhwIjoxNzI4NTYxODI3LCJpYXQiOjE3Mjg0NzU0MjcsImp0aSI6IjAzMTU1OWNiZjM4MTRiZDhhNTkxYzgwOGNiZDM2ZTY5In0.Q3sNO25bw93EB5vjscF1Mgt-EeXmKQ4Sja_vk1v9BMQ")
	req.Header.Set("AuthorizationRefreshToken", "eyJhbGciOiJIbWFjU0hBMjU2IiwidHlwIjoiSldUIn0.eyJpZCI6MSwiZXhwIjoxNzI4NTY0NTM1LCJpYXQiOjE3Mjg0NzgxMzUsImp0aSI6Ijk4NmVhNGE2MmE4ZTQ1OThhNDNjZWJkOTk1ZmNiZjM2In0.B9YqnU59kr8KRtiExtmwwCBxLSxo6mh-53woJIT_mPM")

	// 发送请求
	client := &http.Client{}
	resp, err := client.Do(req)
	if err != nil {
		fmt.Println("Error sending request:", err)
		return
	}
	defer resp.Body.Close()

	// 读取响应体内容
	body, err := ioutil.ReadAll(resp.Body)
	if err != nil {
		fmt.Println("Error reading response body:", err)
		return
	}

	fmt.Println("Response Status:", resp.Status)
	fmt.Println("Response Body:", string(body))
}

func main() {
	var wg sync.WaitGroup
	start := time.Now()

	for i := 0; i < numRequests; i++ {
		wg.Add(1)
		go makeRequest(&wg)
	}

	// 等待所有请求完成
	wg.Wait()

	duration := time.Since(start)
	fmt.Printf("Completed %d requests in %v\n", numRequests, duration)
}

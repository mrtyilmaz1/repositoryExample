package com.repositoryExample.managementExample;

import com.repositoryExample.managementExample.enums.ProductEnum;
import com.repositoryExample.managementExample.repository.CustomerRepository;
import com.repositoryExample.managementExample.repository.OrderRepository;
import com.repositoryExample.managementExample.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Scanner;



@SpringBootApplication
@RequiredArgsConstructor /*Lombok kütüphanesinde bulunan bir anotasyondur ve genellikle
 sınıfların constructor'larını otomatik olarak oluşturmak için kullanılır.
  Bu anotasyon, sınıfın final olarak işaretlenmiş tüm alanları için constructor'lar oluşturur.
  Bu, sınıfın bağımlılıklarını otomatik olarak enjekte etmek ve ilgili alanlara erişim
  sağlamak için kullanışlıdır.*/
public class ManagementExampleApplication implements CommandLineRunner /* CommandLineRunner
 Spring Framework tarafından sağlanan bir arayüzdür ve Spring uygulamalarında başlangıçta çalıştırılması gereken
  özel bir logic veya işlevi içeren metodu temsil eder.
   Bu arayüzü uygulayan sınıflar, Spring uygulaması başlatıldığında
    bu metodun otomatik olarak çalıştırılmasını sağlar.*/ {
		private final CustomerRepository customerRepository;
		private final OrderRepository orderRepository;
		private final ProductRepository productRepository;

	public static void main(String[] args) {
		SpringApplication.run(ManagementExampleApplication.class, args);
	}

	@Override
	public void run(String... args) /* run metodu ile uygulamanın başlangıcında yapılması gereken işlemleri içerir. */{
		Scanner scanner = new Scanner(System.in);
		System.out.println("Ürünler: ");
		String productName = scanner.next();
		ProductEnum selectedProduct = ProductEnum.valueOf(productName);
		Long productId = productRepository.findByProductName(selectedProduct)
				.orElseThrow(() -> new RuntimeException("no lesson")).getProductId();

		List<Long> customerNoList = orderRepository.findByProductIdJPQL(productId);
		customerRepository.findAllById(customerNoList);
		// Bu kodun amacı, belirli bir ürün kimliği temelinde siparişlerin müşteri numaralarını almak
		// ve bu müşteri numaralarını kullanarak ilgili müşterileri getirmektir.
		// Bu tür işlemler, genellikle veri tabanı işlemlerinde ilişkili tablolardan veri çekme
		// ve ilişkili verileri işleme ihtiyacı duyulduğunda kullanılır.
	}

}

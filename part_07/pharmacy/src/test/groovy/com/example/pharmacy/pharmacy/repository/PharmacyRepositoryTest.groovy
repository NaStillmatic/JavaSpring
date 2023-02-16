package com.example.pharmacy.pharmacy.repository

import com.example.pharmacy.AbstractIntegrationContainerBaseTest
import com.example.pharmacy.pharmacy.entity.Pharmacy
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class PharmacyRepositoryTest extends AbstractIntegrationContainerBaseTest {

    @Autowired
    private PharmacyRepository pharmacyRepository

    def "PharmacyRepository save"() {

        given:
        String address = "서울 특별시 성북구 종암동"
        String name = "은혜 약국"
        double latitude = 36.11
        double longitude = 128.11

        when:
        def pharmacy = Pharmacy.builder()
        .pharmacyAddress(address)
        .pharmacyName(name)
        .latitude(latitude)
        .longitude(longitude)
        .build()

        def result = pharmacyRepository.save(pharmacy)

        then:
        result.getPharmacyAddress() == address
        result.getPharmacyName() == name
        result.getLatitude() == latitude
        result.getLongitude() == longitude
    }
}

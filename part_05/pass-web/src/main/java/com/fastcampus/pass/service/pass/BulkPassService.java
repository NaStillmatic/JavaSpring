package com.fastcampus.pass.service.pass;

import com.fastcampus.pass.controller.admin.BulkPassRequest;
import com.fastcampus.pass.repository.packaze.PackageEntity;
import com.fastcampus.pass.repository.packaze.PackageRepository;
import com.fastcampus.pass.repository.pass.BulkPassEntity;
import com.fastcampus.pass.repository.pass.BulkPassRepository;
import com.fastcampus.pass.repository.pass.BulkPassStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BulkPassService {
    private final BulkPassRepository bulkPassRepository;
    private final PackageRepository packageRepository;

    public BulkPassService(BulkPassRepository bulkPassRepository, PackageRepository packageRepository) {
        this.bulkPassRepository = bulkPassRepository;
        this.packageRepository = packageRepository;
    }
    public List<BulkPass> getAllBulkPasses() {
        // startedAt 역순으로 모든 bulkPass 를 조회합니다.
        List<BulkPassEntity> bulkPassEntities = bulkPassRepository.findAllOrderByStartedAtDesc();
        return BulkPassModelMapper.INSTANCE.map(bulkPassEntities);
    }
    public void addBulkPass(BulkPassRequest bulkPassRequest) {
        // bulkPassRequest 를 기반으로 passEntity 를 생성하여 DB에 저장합니다.
        PackageEntity packageEntity = packageRepository.findById(bulkPassRequest.getPackageSeq()).orElseThrow();

        BulkPassEntity bulkPassEntity = BulkPassModelMapper.INSTANCE.map(bulkPassRequest);
        bulkPassEntity.setStatus(BulkPassStatus.READY);
        bulkPassEntity.setCount(packageEntity.getCount());
        bulkPassEntity.setEndedAt(packageEntity.getPeriod());

        bulkPassRepository.save(bulkPassEntity);
    }
}

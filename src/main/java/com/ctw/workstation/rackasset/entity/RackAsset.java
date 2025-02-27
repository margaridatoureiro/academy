package com.ctw.workstation.rackasset.entity;

import com.ctw.workstation.rack.entity.Rack;
import jakarta.persistence.*;

@Entity
@Table(name = "T_RACK_ASSET")
public class RackAsset {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "rackAssetIdGenerator")
    @SequenceGenerator(name = "rackAssetIdGenerator", sequenceName = "SEQ_RACK_ASSET_ID")
    public Long id;

    @Column(name = "asset_tag", nullable = false)
    public String assetTag;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rack_id", referencedColumnName = "id", nullable = false)
    public Rack rack;


    public RackAsset(String assetTag, Rack rack) {
        this.assetTag = assetTag;
        this.rack = rack;
    }

    public RackAsset() {
    }
}
